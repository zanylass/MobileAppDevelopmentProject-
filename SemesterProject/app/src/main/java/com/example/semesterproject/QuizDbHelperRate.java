package com.example.semesterproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class QuizDbHelperRate extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MathRateQuiz1.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;
    public QuizDbHelperRate(Context context) {
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
        Question q1 = new Question("Vivi is a drummer for a band. She burns 756 calories while drumming for 3 hours. She burns the same number of calories each hour.\n How many calories does Vivi burn per hour?", "A: 249", "B: 252", "C: 253","D: 256", 2);
        addQuestion(q1);
        Question q2 = new Question("Luke can paint 91 portraits in 7 weeks.\nHow many portraits can Luke paint in 4 weeks?", "A: 52", "B: 36", "C: 66","D: 42", 1);
        addQuestion(q2);
        Question q3 = new Question("A box of 15 cookies costs $9.\nWhat is the cost for 1 cookie?", "A: 0.55", "B: 0.68", "C: 0.60","D: 0.62", 3);
        addQuestion(q3);
        Question q4 = new Question("Julio bikes 5 miles in 20 minutes on the Walkway over the Hudson.\nHow many miles per minute does Julio bike?", "A: 2.5 miles per minute", "B: 0.25 miles per minute", "C: 0.25 miles per hour","D: 2.5 miles per hour", 2);
        addQuestion(q4);
        Question q5 = new Question(" Movie ticket sales are as follows:\n" +
                "Adult: 20 tickets for $250\n" +
                "Child: 15 tickets for $71.25\n" +
                "Senior: 5 tickets for $37.50\n" +
                "How much does one (1) SENIOR ticket cost?", "A: $7.00", "B: $0.13", "C: $32.50","D: $7.50", 4);
        addQuestion(q5);
        Question q6 = new Question("A store sees 120 customers in 12 hours.\nWhat is the unit rate (in customers per hour)?", "A: 6 customers per hour", "B: 10 customers per hour", "C: 12 customers per hour","D: 20 customers per hour", 2);
        addQuestion(q6);
    }
    private void addQuestion(Question question) {
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
