package com.example.semesterproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class QuizDbHelperNN2 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MothNN2Quiz.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;
    public QuizDbHelperNN2(Context context) {
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
        Question q1 = new Question("2.888+42=?", "A: 44.888", "B: 43.888", "C: 44.8","D: 44.88", 1);
        addQuestion(q1);
        Question q2 = new Question("To visit his grandmother, Luis takes a train 6.37 kilometers and a car 5.45 kilometers.\nHow many kilometers is Luis's journey in total?", "A: 13.86", "B: 11.82", "C: 12.88","D: 10.54", 2);
        addQuestion(q2);
        Question q3 = new Question("Cayden has several screws on a scale, and the scale reads 80.955 g. Cayden adds 1 more screw, and the scale reads 84.81 g.\nWhat is the mass of the last screw Cayden adds?", "A: 3.855g", "B: 4.657g", "C: 2.845g","D: 3.085g", 1);
        addQuestion(q3);
        Question q4 = new Question("A relay race covers 3/2 kilometers, and each runner on a team will run 1/4 of a kilometer.\nHow many runners are needed for a team?", "A: 8 runners", "B: 4 runners", "C: 6 runners","D: 9 runners", 3);
        addQuestion(q4);
        Question q5 = new Question("A piano 9/2 hours available to teach in a night. Each lesson will last 3/2 hours.\n How many lessons can the teacher schedule in a night?", "A: 6 lessons", "B: 5 lessons", "C: 9 lessons","D: 3 lessons", 4);
        addQuestion(q5);
        Question q6 = new Question("A baker has 21/4 pieces in her shop. She cut the pies in pieces that are each 1/8 of a whole pie. How many pieces of pie does she have?", "A: 36 pieces", "B: 48 pieces", "C: 42 pieces","D: 40 pieces", 3);
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

