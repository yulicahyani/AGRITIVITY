package com.bc0098.agritivity.utils

import com.bc0098.agritivity.R
import com.bc0098.agritivity.data.PetaniEntity

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
                        "085123345221",
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
                        "089786538490",
                        "Saya pekerja yang sangat rajin pantang menyerah dan siap bekerja keras.",
                        R.drawable.petani
                )
        )

        return petani
    }
}