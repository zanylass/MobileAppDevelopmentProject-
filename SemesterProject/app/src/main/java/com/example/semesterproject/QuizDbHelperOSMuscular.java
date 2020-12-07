package com.example.semesterproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class QuizDbHelperOSMuscular extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ScienceQuizOS2Muscular.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;
    public QuizDbHelperOSMuscular(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.QuestionsTable.TABLE_NAME + " ( " +
                QuizContract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }


    private void fillQuestionsTable() {
        Question q1 = new Question("The muscle that makes up the heart is known as the _______ muscle.",
                "A: Cardiac", "B: Face",
                "C: Tendons","D: Skeletal", 1);
        addQuestion(q1);
        Question q2 = new Question("What are quardiceps?",
                "A: Muscles found at the front of the shin",
                "B: Muscles found at the front of the thigh",
                "C: Muscles found at the back of the shin",
                "D: Muscles found at the back of the thigh", 2);
        addQuestion(q2);
        Question q3 = new Question("Your deltoid muscle helps you move your ?",
                "A: shoulder", "B: neck", "C: foot","D: knee", 1);
        addQuestion(q3);
        Question q4 = new Question("What are some of the biggest and most powerful muscles?",
                "A: Neck muscles", "B: Face muscles",
                "C: Thigh and calves","D: Skeletal", 3);
        addQuestion(q4);
        Question q5 = new Question("Smooth muscles are also known as?",
                "A: Cardiac", "B: Skeletal",
                "C: Voluntary","D: Involuntary", 4);
        addQuestion(q5);
        Question q6 = new Question("Which of the following is true?",
                "A: Tendons are special muscles", "B: Pectorals are present in your face",
                "C: Tongue is a muscle","D: Biceps are muscles on the leg", 3);
        addQuestion(q6);
    }

    void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuizContract.QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuizContract.QuestionsTable.TABLE_NAME, null, cv);
    }
    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
