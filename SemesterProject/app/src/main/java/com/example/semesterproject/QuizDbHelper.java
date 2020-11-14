package com.example.semesterproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.semesterproject.QuizContract;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MathRatioQuiz.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;
    public QuizDbHelper(Context context) {
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
        Question q1 = new Question("Leon is helping his baby sister Dalphne eat her dinner. There are 12 peas left in Daphne's bowl and 7 peas squished in her hair. What is the ratio of peas in Daphne's bowl to peas in her hair?", "A: 12 for every 7", "B: 7 for every 12", "C: 7 for every 19","D: 19 for every 7", 1);
        addQuestion(q1);
        Question q2 = new Question("Erin loves to play sports! She has earned 3 tennis trophies, 4 basketball trophies, 7 soccer trophies, and 1 volleyball trophy. What is the ratio of Erin's tennis trophies to soccer trophies?", "A: 3:7", "B: 4:7", "C: 7:4","D: 3:12", 1);
        addQuestion(q2);
        Question q3 = new Question("Quinn has a large family. She has 4 cousins who live in Texas, 3 cousins who live in Nebraska, and 9 cousins who live in Michigan. What is the ratio of Quinn's cousins who live in Michigan?", "A: 4 to 3", "B: 3 to 4", "C: 4 to 9","D: 4 to 12", 3);
        addQuestion(q3);
        Question q4 = new Question("Dean loves rocks! He has 6 pieces of granite, 3 pieces of marble, 14 pieces of sandstone, and 1 piece of slate. What is the ratio of pieces of sandstone to pieces of marble in Dean's collection?", "A: 14:6", "B: 3:24", "C: 14:3","D: 24:3", 3);
        addQuestion(q4);
        Question q5 = new Question("An artist used 6 tubes of red paint, 2 tubes of yellow paint, 13 tubes of white paint, and 9 tubes of blue paint for a mural. What is the ratio of tubes of red paint to bes of white paint?", "A: 6 for every 9", "B: 6 for every 13", "C: 6 for every 30","D: 13 for every 6", 2);
        addQuestion(q5);
        Question q6 = new Question("For the perfect cup of hot cocoa, Eva uses 3 scoops of hot cocoa mix, 10 miniature marshmallows, and 8 ounces of water. What is the ratio of scoops of hot cocoa to miniature marshmallows?", "A: 3 to 8", "B: 3 to 10", "C: 8 to 3","D: 3 to 18", 2);
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
