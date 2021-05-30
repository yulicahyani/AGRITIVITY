package com.bc0098.agritivity.data.source.entity

import com.bc0098.agritivity.data.source.remote.response.SourceResponse

data class BeritaEntity (
        val author: String,
        val title: String,
        val description: String,
        val waktu: String,
        val sumber: SourceResponse,
        val image: String,
        val content: String
)