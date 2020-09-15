<template>
    <v-container fluid class="text-center align-center">
        <h2>ElasticSearch 기술을 활용한 네이버 댓글 수사대</h2>
        <v-row class="my-10 px-3">
            <v-text-field
                v-model="input"
                outlined
                label="유사도를 판정할 댓글을 입력하세요"
            ></v-text-field>
            <v-btn class="mx-3 mb-5" fab dark large depressed color="teal">
                <v-icon dark>mdi-magnify</v-icon>
            </v-btn>
        </v-row>
        <h3>Results Length : {{ results.length }}</h3>
        <v-data-table
            :headers="headers"
            :items="results"
            :item-class= "row_class"
            :items-per-page="5"
            class="elevation-1"
        ></v-data-table>
    </v-container>
</template>

<script>
export default {
    name: 'Home',
    data() {
        return {
            input: '',
            headers: [
                { text: '유사도 점수', align: 'center', value: 'score' },
                { text: '댓글 내용', align: 'center', sortable: false, value: 'comment' },
            ],
            results: [
                {
                    score: 1.5423828,
                    comment: '술 마시고 운전하면 좋아..',
                },
                {
                    score: 0.8543997,
                    comment: '음주운전 처벌해주세요',
                },
                {
                    score: 0.8543997,
                    comment: '음주운전 할 수도 있지..',
                },
                {
                    score: 0.7641983,
                    comment: '음주운전자는 현장에서 사살해야 된다.',
                },
            ],
        }
    },
    methods: {
        row_class(result) {
            if (result.score >= 3) {
                return 'orangered';
            }
        }
    },
}
</script>

<style>
.orangered {
    background-color:rgba(255, 69, 0, 0.3)
}
</style>
