<template>
  <div class="ani">
    <div
      class="ani-block"
      v-for="(item, index) in block"
      :key="index"
      @click="bindTapBlock(item.blockNumber)"
    >
      <div>{{ item.blockNumber }}</div>
      <div class="ani-block-miner">
        {{ languageData.etheric_block_table.blockMiner }}：{{ item.blockMiner }}
      </div>
      <div class="ani-block-time">
        {{ languageData.etheric_block_table.time }}：{{ item.time }}
      </div>
      <div class="linkline" v-if="index !== block.length - 1"></div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import qs from "qs";
import data from "@/assets/data/data";

export default {
  name: "ETHERIC_Animate",
  props: ["languageData"],
  data() {
    return {
      block: [],
      addFactor: 0,
      timeout: null,
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
    bindTapBlock(blockNum) {
      this.$router.push("/search_result/" + blockNum + "?type=etheric");
    },
    //查询区块信息
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
            let data = res.data.result;
            data.time = formatDate(data.timeStamp * 1000);
            _this.blockData.blockno++;
            _this.block.push(data);
            _this.timeout = setTimeout(function() {
              if (_this.addFactor == 7) {
                _this.block = [];
                _this.addFactor = 0;
                clearTimeout(_this.timeout);
              }
              _this.getEthericBlock();
              _this.addFactor++;
            }, 1000);
          } else {
            _this.timeout = setTimeout(function() {
              _this.getEthericBlock();
            }, 1000);
          }
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

<style scoped lang="scss">
.ani {
  width: 100%;
  height: 60vh;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
  box-sizing: border-box;
}
.ani-block {
  width: 200px;
  min-height: 80px;
  background: #409eff;
  border-radius: 4px;
  color: #fff;
  padding: 10px;
  box-sizing: border-box;
  margin: 0 20px;
  position: relative;
  cursor: pointer;
  .ani-block-miner {
    white-space: pre-wrap;
    word-break: break-all;
  }
  .linkline {
    position: absolute;
    top: 40px;
    right: -40px;
    width: 40px;
    height: 2px;
    background: #cccccc;
  }
}
</style>
