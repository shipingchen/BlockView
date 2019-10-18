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
        prop="uncleInclusionReward"
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
      tablePageData: [],
      blockData: {
        module: "block",
        action: "getblockreward",
        blockno: data.ETHERIC_blockno,
        key: "D57YAMFECX6KHQI746H7MCKRKT9E3GH8EZ"
      }
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
        method: "post",
        url: "https://api.etherscan.io/api",
        headers: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        data: qs.stringify(_this.blockData)
      })
        .then(function(res) {
          if (res.data.status == "1") {
            let data = res.data.result,
              blockno = parseInt(_this.blockData.blockno);
            blockno++;
            _this.blockData.blockno = blockno;
            data.time = formatDate(data.timeStamp * 1000);
            _this.tableData.unshift(data);
            _this.getPageData();
          }
          setTimeout(function() {
            _this.getEthericBlock();
          }, 1000);
        })
        .catch(function(err) {
          console.log(err);
          setTimeout(function() {
            _this.getEthericBlock();
          }, 1000);
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
