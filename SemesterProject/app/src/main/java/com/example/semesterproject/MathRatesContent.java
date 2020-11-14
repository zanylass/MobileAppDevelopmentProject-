package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;

import org.w3c.dom.Text;


public class MathRatesContent extends AppCompatActivity {
    public TextView ratesContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_rates_content);
        ratesContent=(TextView)findViewById(R.id.textViewContent);
        //http://www.eduplace.com/math/mathsteps/6/e/#:~:text=A%20rate%20is%20a%20special,or%2069%C2%A2%3A12%20ounces.
        ratesContent.setText("A ratio is a comparison of two numbers or measurements. The numbers or measurements being compared are called the terms of the ratio. A rate is a special ratio in which the two terms are in different units. For example, if a 12-ounce can of corn costs 69¢, the rate is 69¢ for 12 ounces. The first term of the ratio is measured in cents; the second term in ounces. You can write this rate as 69¢/12 ounces or 69¢:12 ounces. Both expressions mean that you pay 69¢ \"for every\" 12 ounces of corn.\n" +
                "\n" +
                "Rates are used by people every day, such as when they work 40 hours a week or earn interest every year at a bank. When rates are expressed as a quantity of 1, such as 2 feet per second or 5 miles per hour, they are called unit rates. If you have a multiple-unit rate such as 120 students for every 3 buses, and want to find the single-unit rate, write a ratio equal to the multiple-unit rate with 1 as the second term.\n" +
                "\n" +
                "120/3 = 40/1\n" +
                "The unit rate of 120 students for every 3 buses is 40 students per bus. You could also find the unit rate by dividing the first term of the ratio by the second term. When prices are expressed as a quantity of 1, such as $25 per ticket or $0.89 per can, they are called unit prices. If you have a multiple-unit price, such as $5.50 for 5 pounds of potatoes, and want to find the single-unit price, divide the multiple-unit price by the number of units.\n" +
                "\n" +
                "$5.50 ÷ 5 = $1.10\n" +
                "The unit price of potatoes that cost $5.50 for 5 pounds is $1.10 per pound.\n" +
                "\n" +
                "Rates and unit rates are used to solve many real-world problems. Look at the following problem. \"Tonya works 60 hours every 3 weeks. At that rate, how many hours will she work in 12 weeks?\" The problem tells you that Tonya works at the rate of 60 hours every 3 weeks. To find the number of hours she will work in 12 weeks, write a ratio equal to 60/3 that has a second term of 12.\n" +
                "\n" +
                "60/3 = 240/12\n" +
                "Tonya will work 240 hours in 12 weeks.\n" +
                "\n" +
                "You could also solve this problem by first finding the unit rate and multiplying it by 12.\n" +
                "\n" +
                "60/3 = 20/1\n" +
                "20 x 12 = 240\n" +
                "When you find equal ratios, it is important to remember that if you multiply or divide one term of a ratio by a number, then you need to multiply or divide the other term by that same number. Now let's take a look at a problem that involves unit price. \"A sign in a store says 3 Pens for $2.70. How much would 10 pens cost?\" To solve the problem, find the unit price of the pens, then multiply by 10.\n" +
                "\n" +
                "$2.70 ÷ 3 = $0.90\n" +
                "$0.90 times 10 = $9.00\n" +
                "Finding the cost of one unit first makes it easy to find the cost of multiple units.");
        ratesContent.setMovementMethod(new ScrollingMovementMethod());
    }
}