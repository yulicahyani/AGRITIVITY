package com.bc0098.agritivity.data.source.entity

import com.bc0098.agritivity.data.source.remote.response.Id
import com.bc0098.agritivity.data.source.remote.response.Snippet

data class PanduanEntity (
        val id: Id,
        val snippet: Snippet,
)