<template>
    <div class="block">
        <el-table
                :data="tableData"
                stripe
                border
                style="width: 80%;margin: 0 auto;"
                :empty-text="languageData.table_empty_text"
        >
            <el-table-column prop="height" :label="languageData.eos_block_table.height">
            </el-table-column>
            <el-table-column
                    prop="transactions"
                    :label="languageData.eos_block_table.transactions"
            >
            </el-table-column>
            <el-table-column
                    prop="user"
                    :label="languageData.eos_block_table.user"
            >
            </el-table-column>
            <el-table-column
                    prop="create_time"
                    :label="languageData.eos_block_table.time"
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
        name: "block",
        props: ["languageData"],
        data() {
            return {
                tableData: []
            };
        },
        mounted() {
            this.tableData = data.blockData;
        }
    };
</script>

<style scoped>
    .block{
        padding: 20px;
    }
</style>
