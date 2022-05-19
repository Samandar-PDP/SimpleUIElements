package com.example.simpleuielements.util

import com.example.simpleuielements.R
import com.example.simpleuielements.model.Footballer

object ObjectList {
    fun footballerList(): ArrayList<Footballer> {
        return arrayListOf(
            Footballer(
                "Messi",
                "Leo",
                R.drawable.messi,
                15,
                false
            ),
            Footballer(
                "Ronaldo",
                "Cristiano",
                R.drawable.ronaldo,
                2,
                true
            ),
            Footballer(
                "Kane",
                "Harry",
                R.drawable.kane,
                52,
                false
            ),
            Footballer(
                "Son",
                "Hyon",
                R.drawable.son,
                15,
                false
            ),
            Footballer(
                "Salah",
                "Muhammad",
                R.drawable.salah,
                32,
                false
            ),
            Footballer(
                "Messi",
                "Leo",
                R.drawable.messi,
                15,
                true
            ),
            Footballer(
                "Ronaldo",
                "Cristiano",
                R.drawable.ronaldo,
                15,
                true
            ),
            Footballer(
                "Kane",
                "Harry",
                R.drawable.kane,
                15,
                true
            ),
            Footballer(
                "Son",
                "Hyon",
                R.drawable.son,
                15,
                false
            ),
            Footballer(
                "Salah",
                "Muhammad",
                R.drawable.salah,
                15,
                true
            ),
        )
    }
}