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
        prop="height"
        :label="languageData.btc_block_table.height"
      >
      </el-table-column>

      <el-table-column prop="hash" :label="languageData.btc_block_table.hash">
      </el-table-column>
      <el-table-column prop="size" :label="languageData.btc_block_table.size">
      </el-table-column>
      <el-table-column
        prop="tx_count"
        :label="languageData.btc_block_table.tx_count"
      >
      </el-table-column>
      <el-table-column
        prop="confirmations"
        :label="languageData.btc_block_table.confirmations"
      >
      </el-table-column>
      <el-table-column prop="time" :label="languageData.btc_block_table.time">
      </el-table-column>
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
import data from "@/assets/data/data";
export default {
  name: "BTC_block",
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
    this.getBTCBlock();
  },

  methods: {
    pageChange(e) {
      this.pageNum = e;
      this.getPageData();
    },
    getPageData() {
      if (this.tableData.length > 0) {
        let pageNum = this.pageNum,
          limit = this.limit,
          tableData = JSON.parse(JSON.stringify(this.tableData));
        this.tablePageData = tableData.slice(
          (pageNum - 1) * limit,
          pageNum * limit
        );
      }
    },
    getBTCBlock() {
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
        url: "/bitcoin"
      })
        .then(function(res) {
          if (res.data.length > 0) {
            let result = res.data;
            for (let i in result) {
              result[i].time = formatDate(result[i].timestamp * 1000);
            }
            _this.tableData = result;
            _this.getPageData();
          }
          _this.timeout = setTimeout(function() {
            _this.getBTCBlock();
          }, 1000);
          _this.$once("hook:beforeDestroy", () => {
            clearTimeout(_this.timeout);
          });
        })
        .catch(function(err) {
          console.log(err);
          _this.timeout = setTimeout(function() {
            _this.getBTCBlock();
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
