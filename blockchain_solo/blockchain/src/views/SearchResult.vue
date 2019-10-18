<template>
  <div class="block">
    <div v-if="type === 'all' || type === 'etheric'">
      <h2 style="width: 80%;margin: 20px auto;">
        {{ languageData.searchResult.etheric_block }}
      </h2>
      <el-table
        :data="ethericData"
        stripe
        border
        style="width: 80%;margin: 0 auto;"
        :empty-text="languageData.table_empty_text"
      >
        <el-table-column
          prop="blockNumber"
          :label="languageData.etheric_block_table.blockNumber"
        >
        </el-table-column>
        <el-table-column
          prop="blockReward"
          :label="languageData.etheric_block_table.blockReward"
        >
        </el-table-column>
        <el-table-column
          prop="blockMiner"
          :label="languageData.etheric_block_table.blockMiner"
        >
        </el-table-column>
        <el-table-column
          prop="time"
          :label="languageData.etheric_block_table.time"
        >
        </el-table-column>
      </el-table>
      <br />
    </div>

    <div v-if="type === 'all' || type === 'btc'">
      <h2 style="width: 80%;margin: 20px auto;">
        {{ languageData.searchResult.btc_block }}
      </h2>
      <el-table
        :data="btcData"
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
      <br />
    </div>
  </div>
</template>

<script>
import axios from "axios";
import qs from "qs";
function formatDate(timestamp) {
  let now = new Date(timestamp),
    year = now.getFullYear(),
    month = now.getMonth() + 1,
    date = now.getDate(),
    hour = now.getHours(),
    minute = now.getMinutes(),
    second = now.getSeconds();
  return (
    year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second
  );
}
export default {
  name: "SearchResult",
  props: ["languageData", "minerList"],
  data() {
    return {
      ethericData: [],
      btcData: [],
      type: "",
      blockData: {
        module: "block",
        action: "getblockreward",
        blockno: "8623104",
        key: "D57YAMFECX6KHQI746H7MCKRKT9E3GH8EZ"
      }
    };
  },
  watch: {
    $route(to) {
      // Response to the route change...
      this.blockData.blockno = to.params.search_content;
      this.type = this.$route.query.type ? this.$route.query.type : "";
      this.getEthericBlock();
      this.getBTCBlock();
    }
  },
  mounted() {
    this.blockData.blockno = this.$route.params.search_content;
    this.type = this.$route.query.type ? this.$route.query.type : "all";
    switch (this.type) {
      case "all":
        this.getEthericBlock();
        this.getBTCBlock();
        break;
      case "btc":
        this.getBTCBlock();
        break;
      case "etheric":
        this.getEthericBlock();
        break;
      default:
        break;
    }
  },
  methods: {
    
    getEthericBlock() {
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
          if (res.data.status === "1") {
            let data = res.data.result;
            data.time = formatDate(data.timeStamp * 1000);
            _this.ethericData = [data];
          }
        })
        .catch(function(err) {
          console.log(err);
        });
    },
    
    getBTCBlock() {
      let _this = this;
      axios({
        method: "get",
        url: "https://chain.api.btc.com/v3/block/" + _this.blockData.blockno
      })
        .then(function(res) {
          if (res.data.data) {
            let data = res.data.data;
            data.time = formatDate(data.timestamp * 1000);
            _this.btcData = [data];
          }
        })
        .catch(function(err) {
          console.log(err);
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
