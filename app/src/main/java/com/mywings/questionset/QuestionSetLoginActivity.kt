package com.mywings.questionset

import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_question_set_login.*


class QuestionSetLoginActivity : QuestionSetCompactActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_set_login)
        setSupportActionBar(toolbar)
    }
}
