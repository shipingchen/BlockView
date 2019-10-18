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
import data from "@/assets/data/data";
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
      blockno: "8623104"
    };
  },
  watch: {
    $route(to) {
      // Reaction for Routing Response...
      this.blockData.blockno = to.params.search_content;
      this.type = this.$route.query.type ? this.$route.query.type : "";
      this.getEthericBlock();
      this.getBTCBlock();
    }
  },
  mounted() {
    this.blockno = this.$route.params.search_content;
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
    //Get block info
    getEthericBlock() {
      let _this = this;
      axios({
        method: "get",
        baseURL: data.baseURL,
        url: "/getOneEthereum/" + _this.blockno
      })
        .then(function(res) {
          if (res.data) {
            let data = res.data;
            data.time = formatDate(data.timeStamp * 1000);
            _this.ethericData = [data];
          } else {
            _this.ethericData = [];
          }
        })
        .catch(function(err) {
          console.log(err);
        });
    },
    //Get block info
    getBTCBlock() {
      let _this = this;
      axios({
        method: "get",
        baseURL: data.baseURL,
        url: "/getOneBitcoin/" + _this.blockno
      })
        .then(function(res) {
          if (res.data) {
            let data = res.data;
            data.time = formatDate(data.timestamp * 1000);
            _this.btcData = [data];
          } else {
            _this.btcData = [];
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
