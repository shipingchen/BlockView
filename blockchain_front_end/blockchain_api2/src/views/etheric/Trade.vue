<template>
  <div class="trade">
    <el-table
      :data="tableData"
      stripe
      border
      style="width: 80%;margin: 0 auto;"
      :empty-text="languageData.table_empty_text"
    >
      <el-table-column prop="height" :label="languageData.etheric_trade_table.height">
      </el-table-column>
      <el-table-column
        prop="hash"
        :label="languageData.etheric_trade_table.hash"
      >
      </el-table-column>
      <el-table-column
        prop="send_user"
        :label="languageData.etheric_trade_table.send_user"
      >
      </el-table-column>
      <el-table-column
        prop="recevie_user"
        :label="languageData.etheric_trade_table.recept_user"
      >
      </el-table-column>
      <el-table-column
        prop="create_time"
        :label="languageData.etheric_trade_table.time"
      >
      </el-table-column>
    </el-table>

    <el-pagination
      background
      layout="prev, pager, next"
      :total="tableData.length"
      style="display: flex;justify-content: center;margin: 20px 0;"
    >
    </el-pagination>
  </div>
</template>

<script>
import data from "@/assets/data/data";
export default {
  name: "Trade",
  props: ["languageData"],
  data() {
    return {
      tableData: []
    };
  },
  mounted() {
    this.tableData = data.tradeData;
  }
};
</script>

<style scoped>
.trade {
  padding: 20px;
}
</style>
