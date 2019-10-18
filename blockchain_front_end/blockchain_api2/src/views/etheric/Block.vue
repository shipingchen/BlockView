<template>
  <div class="block">
    <el-table
      :data="tablePageData"
      stripe
      border
      style="width: 80%;margin: 0 auto;"
      :empty-text="languageData.table_empty_text"
    >
      <el-table-column
        prop="blockNumber"
        :label="languageData.etheric_block_table.blockNumber"
      ></el-table-column>
      <el-table-column
        prop="blockReward"
        :label="languageData.etheric_block_table.blockReward"
      ></el-table-column>
      <el-table-column
        prop="blockMiner"
        :label="languageData.etheric_block_table.blockMiner"
      ></el-table-column>
      <el-table-column
        prop="uncleReward"
        :label="languageData.etheric_block_table.uncleInclusionReward"
      ></el-table-column>
      <el-table-column
        prop="time"
        :label="languageData.etheric_block_table.time"
      ></el-table-column>
    </el-table>

    <el-pagination
      background
      layout="prev, pager, next"
      :page-size="limit"
      :total="tableData.length"
      @current-change="pageChange"
      style="display: flex;justify-content: center;margin: 20px 0;"
    ></el-pagination>
  </div>
</template>

<script>
import axios from "axios";
import qs from "qs";
import data from "@/assets/data/data";

export default {
  name: "block",
  props: ["languageData"],
  data() {
    return {
      tableData: [],
      limit: 10,
      pageNum: 1,
      timeout: null,
      tablePageData: []
    };
  },
  mounted() {
    this.getEthericBlock();
  },
  methods: {
    pageChange(e) {
      this.pageNum = e;
      this.getPageData();
    },
    getPageData() {
      let pageNum = this.pageNum,
        limit = this.limit,
        tableData = JSON.parse(JSON.stringify(this.tableData));
      this.tablePageData = tableData.slice(
        (pageNum - 1) * limit,
        pageNum * limit
      );
    },
    getEthericBlock() {
      function formatDate(timestamp) {
        let now = new Date(timestamp),
          year = now.getFullYear(),
          month = now.getMonth() + 1,
          date = now.getDate(),
          hour = now.getHours(),
          minute = now.getMinutes(),
          second = now.getSeconds();
        return (
          year +
          "-" +
          month +
          "-" +
          date +
          " " +
          hour +
          ":" +
          minute +
          ":" +
          second
        );
      }
      let _this = this;
      axios({
        method: "get",
        baseURL: data.baseURL,
        url: "/ethereum"
      })
        .then(function(res) {
          console.log(res.data)
          if (res.data.length > 0) {
            let result = res.data;
            
            
            for (let i in result) {
              result[i].time = formatDate(result[i].timeStamp * 1000);
            }
            _this.tableData = result;
            _this.getPageData();
          }
          _this.timeout = setTimeout(function() {
            _this.getEthericBlock();
          }, 1000);
          _this.$once("hook:beforeDestroy", () => {
            clearTimeout(_this.timeout);
          });
        })
        .catch(function(err) {
          console.log(err);
          _this.timeout = setTimeout(function() {
            _this.getEthericBlock();
          }, 1000);
          _this.$once("hook:beforeDestroy", () => {
            clearTimeout(_this.timeout);
          });
        });
    }
  }
};
</script>

<style scoped>
.block {
  padding: 20px;
}
</style>
