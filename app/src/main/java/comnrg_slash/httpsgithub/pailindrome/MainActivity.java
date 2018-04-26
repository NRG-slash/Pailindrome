/**
 * Name: Garrett Laturski
 * Teacher: Mr.Hardman
 * Corse CS30S
 * date last edited: 4/26/2018
 */
package comnrg_slash.httpsgithub.pailindrome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mWordInput;
    private TextView mErrorMessage;
    private TextView mDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWordInput = (EditText) findViewById(R.id.et_word_input);
        mErrorMessage = (TextView) findViewById(R.id.tv_error_message);
        mDisplay = (TextView) findViewById(R.id.tv_display);
    }

    private final TextWatcher mWordInputWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
        {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
        {

        }

        @Override
        public void afterTextChanged(Editable editable)
        {
            String wordInput;
            boolean storePalindromeCheck;

            if (editable.length() == 0)
            {
                mDisplay.setText("");
                mErrorMessage.setText("You must enter a word with no spaces!");
            }
            else
            {
                wordInput = mWordInput.getText().toString().toUpperCase();

                storePalindromeCheck = checkPalindrome(wordInput,0);

                if (storePalindromeCheck == true)
                {
                    mErrorMessage.setText("");
                    mDisplay.setText(wordInput + " is a palindrome");
                }
                else
                {
                    mDisplay.setText("");
                    mErrorMessage.setText(wordInput + "isn't a palindrome");
                }
            }

        }
    };

    private boolean checkPalindrome(String userWord, int currentIndex)
    {
        boolean result;
        int indexFromEnd = userWord.length() - currentIndex - 1;

        if (userWord.charAt(currentIndex) == userWord.charAt(indexFromEnd))
        {
            if (currentIndex == indexFromEnd || currentIndex == indexFromEnd -1)
            {
                result = true;
            }
            else
            {
                result = checkPalindrome(userWord, currentIndex +1);
            }
        }
        else
        {
            result = false;
        }

        return result;
    }
}
