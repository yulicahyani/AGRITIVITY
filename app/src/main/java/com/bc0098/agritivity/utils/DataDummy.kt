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
                "Bayu Baskara",
                "Petani(Pemilik Lahan)",
                "Singaraja",
                "2 tahun",
                "Menanam Sayur-sayuran",
                "6285739063468",
                "Saya seorang petani, saya memiliki lahan pertanian seluas 2 hektare",
                R.drawable.user1
            )
        )

        petani.add(
                PetaniEntity(
                        2,
                        "Yuli Cahyani",
                        "Petani(Buruh Tani)",
                        "Karangasem",
                        "1 tahun",
                        "Menanam stroberi",
                        "6285647065215",
                        "Saya pekerja yang sangat rajin pantang menyerah dan siap bekerja keras.",
                        R.drawable.user2
                )
        )

        petani.add(
            PetaniEntity(
                3,
                "Andre Suryana",
                "Petani(Buruh Tani)",
                "Klungkung",
                "4 tahun",
                "Membajak lahan sawah",
                "6281237707811",
                "Saya pekerja yang sangat rajin pantang menyerah dan siap bekerja keras.",
                R.drawable.user3
            )
        )

        petani.add(
            PetaniEntity(
                4,
                "Dewi Lestari",
                "Petani(Pemilik Lahan)",
                "Payangan, Gianyar",
                "2 tahun",
                "Bertani tebu",
                "6281237707811",
                "Saya seorang petani, saya memiliki lahan pertanian seluas 2 hektare.",
                R.drawable.user4
            )
        )

        petani.add(
            PetaniEntity(
                5,
                "Kartika Noviyanti",
                "Petani(Buruh Tani)",
                "Panjer, Denpasar",
                "4 tahun",
                "Menanam dan memanen anggur",
                "6281237707811",
                "Saya pekerja yang sangat rajin pantang menyerah dan siap bekerja keras.",
                R.drawable.user5
            )
        )

        petani.add(
            PetaniEntity(
                6,
                "Udha Krisna Yasa",
                "Petani(Pemilik Lahan)",
                "Tabanan",
                "6 tahun",
                "Bertani padi",
                "6281237707811",
                "Saya seorang petani, saya memiliki lahan pertanian seluas 2 hektare.",
                R.drawable.user6
            )
        )

        petani.add(
            PetaniEntity(
                7,
                "Trisna Wahyudi",
                "Petani(Buruh Tani)",
                "Kesiman, Denpasar",
                "5 tahun",
                "Menanam Padi dan Jagung",
                "6281237707811",
                "Saya pekerja yang sangat rajin pantang menyerah dan siap bekerja keras.",
                R.drawable.user7
            )
        )

        petani.add(
            PetaniEntity(
                8,
                "Vidjanantha Wardana",
                "Petani(Buruh Tani)",
                "Ungasan, Badung",
                "5 tahun",
                "Menanam dan memanen padi",
                "6281237707811",
                "Saya pekerja yang sangat rajin pantang menyerah dan siap bekerja keras.",
                R.drawable.user8
            )
        )

        petani.add(
            PetaniEntity(
                9,
                "Anom Sukawirasa",
                "Petani(Buruh Tani)",
                "Gianyar",
                "3 tahun",
                "Menanam dan memanen padi",
                "6281237707811",
                "Saya pekerja yang sangat rajin pantang menyerah dan siap bekerja keras.",
                R.drawable.user9
            )
        )

        petani.add(
            PetaniEntity(
                10,
                "Arya Dwisada",
                "Petani(Buruh Tani)",
                "Karangasem",
                "2 tahun",
                "Menanam dan mengolah lahan",
                "6281237707811",
                "Saya pekerja yang sangat rajin pantang menyerah dan siap bekerja keras.",
                R.drawable.user10
            )
        )

        return petani
    }

    fun generateDummyPekerjaan(): List<PekerjaanEntity>{
        val pekerjaan = ArrayList<PekerjaanEntity>()

        pekerjaan.add(
            PekerjaanEntity(
                1,
                1,
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
                4,
                "Jumat, 4 Juni 2021",
                "Br. Batu, Desa Pererenan,  Menggwi, Badung, Bali",
                "Rp75.000 - Rp125.000",
                "3 orang",
                "5 are",
                "Memanen stroberi yang sudah matang dengan gunting khusus yang sudah disediakan.",
                R.drawable.lahan1
            )
        )

        pekerjaan.add(
            PekerjaanEntity(
                2,
                6,
                "Jumat, 4 Juni 2021",
                "Br. Batu, Desa Pererenan,  Menggwi, Badung, Bali",
                "Rp75.000 - Rp125.000",
                "3 orang",
                "5 are",
                "Memanen stroberi yang sudah matang dengan gunting khusus yang sudah disediakan.",
                R.drawable.lahan2
            )
        )

        pekerjaan.add(
            PekerjaanEntity(
                2,
                4,
                "Jumat, 4 Juni 2021",
                "Br. Batu, Desa Pererenan,  Menggwi, Badung, Bali",
                "Rp75.000 - Rp125.000",
                "3 orang",
                "5 are",
                "Memanen stroberi yang sudah matang dengan gunting khusus yang sudah disediakan.",
                R.drawable.lahan3
            )
        )

        pekerjaan.add(
            PekerjaanEntity(
                2,
                1,
                "Jumat, 4 Juni 2021",
                "Br. Batu, Desa Pererenan,  Menggwi, Badung, Bali",
                "Rp75.000 - Rp125.000",
                "3 orang",
                "5 are",
                "Memanen stroberi yang sudah matang dengan gunting khusus yang sudah disediakan.",
                R.drawable.lahan4
            )
        )

        pekerjaan.add(
            PekerjaanEntity(
                2,
                4,
                "Jumat, 4 Juni 2021",
                "Br. Batu, Desa Pererenan,  Menggwi, Badung, Bali",
                "Rp75.000 - Rp125.000",
                "3 orang",
                "5 are",
                "Memanen stroberi yang sudah matang dengan gunting khusus yang sudah disediakan.",
                R.drawable.lahan5
            )
        )

        return pekerjaan
    }
}