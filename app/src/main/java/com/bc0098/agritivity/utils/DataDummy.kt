package com.bc0098.agritivity.utils

import com.bc0098.agritivity.R
import com.bc0098.agritivity.data.source.entity.PekerjaanEntity
import com.bc0098.agritivity.data.source.entity.PetaniEntity

object DataDummy {

    fun generateDummyPetani(): List<PetaniEntity>{
        val petani = ArrayList<PetaniEntity>()

        petani.add(
                PetaniEntity(
                        1,
                        "Sedana Wijaya",
                        "Petani(Buruh Tani)",
                        "Karangasem",
                        "10 tahun",
                        "Menanam stroberi",
                        "6285647065215",
                        "Saya pekerja yang sangat rajin pantang menyerah dan siap bekerja keras.",
                        R.drawable.petani
                )
        )

        petani.add(
                PetaniEntity(
                        2,
                        "Bayu Baskara",
                        "Petani(Pemilik Lahan)",
                        "Singaraja",
                        "12 tahun",
                        "Menanam Sayur-sayuran",
                        "6285647065215",
                        "Saya pekerja yang sangat rajin pantang menyerah dan siap bekerja keras.",
                        R.drawable.petani
                )
        )

        return petani
    }

    fun generateDummyPekerjaan(): List<PekerjaanEntity>{
        val pekerjaan = ArrayList<PekerjaanEntity>()

        pekerjaan.add(
            PekerjaanEntity(
                1,
                2,
                "Jumat, 4 Juni 2021",
                "Br. Batu, Desa Pererenan,  Menggwi, Badung, Bali",
                "Rp75.000 - Rp125.000",
                "3 orang",
                "5 are",
                "Memanen stroberi yang sudah matang dengan gunting khusus yang sudah disediakan.",
                R.drawable.lahan_stroberi
            )
        )

        pekerjaan.add(
            PekerjaanEntity(
                2,
                2,
                "Jumat, 4 Juni 2021",
                "Br. Batu, Desa Pererenan,  Menggwi, Badung, Bali",
                "Rp75.000 - Rp125.000",
                "3 orang",
                "5 are",
                "Memanen stroberi yang sudah matang dengan gunting khusus yang sudah disediakan.",
                R.drawable.lahan_stroberi
            )
        )

        return pekerjaan
    }
}