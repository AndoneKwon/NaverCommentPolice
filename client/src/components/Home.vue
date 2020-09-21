<template>
    <v-container fluid class="text-center align-center">
        <h2>ElasticSearch 기술을 활용한 네이버 댓글 수사대</h2>
        <v-row class="mt-10 px-3">
            <v-text-field
                v-model="query"
                outlined
                label="유사도를 판정할 댓글을 입력하세요"
                @keyup.enter="submitQuery"
            ></v-text-field>
            <v-btn
                class="mx-3 mb-5"
                fab
                dark
                large
                depressed
                color="teal"
                @click="submitQuery">
                <v-icon dark>mdi-magnify</v-icon>
            </v-btn>
        </v-row>
        <v-alert
            v-model="error"
            v-if="errorMessage"
            type="error"
            text
            outlined
            dismissible
        >
            {{ errorMessage }}
        </v-alert>
        <v-container fluid class="mt-10 text-center align-center">
            <h3 v-if="results.length">Results Length : {{ results.length }}</h3>
        </v-container>
        <v-data-table
            v-if="results.length"
            :headers="headers"
            :items="results"
            :item-class= "rowClass"
            :items-per-page="5"
            class="elevation-1"
        ></v-data-table>
    </v-container>
</template>

<script>
import axios from 'axios';

export default {
    name: 'Home',
    data() {
        return {
            query: '',
            error: false,
            errorMessage: '',
            headers: [
                { text: '유사도 점수', align: 'center', value: 'score' },
                { text: '댓글 내용', align: 'center', sortable: false, value: 'comment' },
            ],
            results: [],
        }
    },
    methods: {
        rowClass(result) {
            if (result.score >= 3) {
                return 'orangered';
            }
        },
        submitQuery() {
            if (!this.query.length) {
                this.error = true;
                this.errorMessage = '검색어를 입력해주세요.';
                return;
            }
            this.error = false;
            this.errorMessage = '';

            const url = 'http://117.17.196.142:8888/search'; 
            const data = { query: this.query };
            const headers = {
                'accept': 'application/json',
                'content-type': 'application/json;charset=UTF-8',
            };

            axios.post(url, data, headers)
            .then(res => {
                if (res.data.length === 0) {
                    this.error = true;
                    this.errorMessage = '검색 결과가 존재하지 않습니다.';
                    return;
                }
                this.results = res.data;
            })
            .catch(err => {
                console.log(err);
            })
        },
    },
}
</script>

<style>
.orangered {
    background-color:rgba(255, 69, 0, 0.3)
}
</style>
