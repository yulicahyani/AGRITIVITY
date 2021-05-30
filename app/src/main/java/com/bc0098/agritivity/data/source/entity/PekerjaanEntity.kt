package com.bc0098.agritivity.data.source.entity

data class PekerjaanEntity (
        val id: Int,
        val idPetani: Int,
        val waktu: String,
        val lokasi: String,
        val upah: String,
        val jmlPekerja: String,
        val luasLahan: String,
        val keterangan: String,
        val fotoLahan: Int
)