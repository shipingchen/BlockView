<template>
  <div class="ani">
    <div
      class="ani-block"
      v-for="(item, index) in block"
      :key="index"
      @click="bindTapBlock(item.height)"
    >
      <div>{{ item.height }}</div>
      <div class="ani-block-miner">
        {{ languageData.btc_block_table.hash }}：{{ item.hash }}
      </div>
      <div class="ani-block-time">
        {{ languageData.btc_block_table.time }}：{{ item.time }}
      </div>
      <div class="linkline" v-if="index !== block.length - 1"></div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import data from "@/assets/data/data";

export default {
  name: "BTC_Animate",
  props: ["languageData"],
  data() {
    return {
      block: [],
      addFactor: 0,
      timeout: null,
      blockno: data.BTC_blockno
    };
  },
  mounted() {
    this.getBTCBlock();
  },
  methods: {
    bindTapBlock(blockNum) {
      this.$router.push("/search_result/" + blockNum + "?type=btc");
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
      let _this = this,
        url = "https://chain.api.btc.com/v3/block/" + _this.blockno;
      axios({
        method: "get",
        url: url
      })
        .then(function(res) {
          if (res.data.data) {
            let data = res.data.data,
              blockno = parseInt(_this.blockno);
            blockno++;
            _this.blockno = blockno;
            data.time = formatDate(data.timestamp * 1000);
            _this.block.push(data);
            _this.timeout = setTimeout(function() {
              if (_this.addFactor == 7) {
                _this.block = [];
                _this.addFactor = 0;
                clearTimeout(_this.timeout);
              }
              _this.getBTCBlock();
              _this.addFactor++;
            }, 1000);
          } else {
            _this.timeout = setTimeout(function() {
              _this.getBTCBlock();
            }, 1000);
          }
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
