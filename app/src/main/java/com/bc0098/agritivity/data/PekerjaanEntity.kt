package com.bc0098.agritivity.data

data class PekerjaanEntity (
        val id: Int,
        val idPetani: Int,
        val notelp: String,
        val fotoPetani: Int,
        val lokasi: String,
        val upah: String,
        val jmlPekerja: String,
        val luasLahan: String,
        val keterangan: String,
        val fotoLahan: Int
)