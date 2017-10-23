package com.example.bastienwcs.atelierregex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText age = (EditText) findViewById(R.id.age);
        final EditText address = (EditText) findViewById(R.id.address);
        final EditText email = (EditText) findViewById(R.id.email);
        Button send = (Button) findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                boolean isNameOk = false;
                // TODO: check Name here
                String lastNameFirstNameEntry = String.valueOf(name.getText());
                Pattern resultName = Pattern.compile("([A-Z][a-z]+([-'\\s][A-Z][a-z]+)?(?=\\s[A-Z])(?:\\s[A-Z][a-z]+)+){1,50}");
                Matcher testName = resultName.matcher(lastNameFirstNameEntry);

                if (testName.matches() == true) {
                    isNameOk = true;
                    Toast.makeText(MainActivity.this, R.string.OKname, Toast.LENGTH_SHORT).show();
                }

                if (!isNameOk) {
                    name.setError(getResources().getString(R.string.error_name));
                }

                boolean isAgeOk = false;
                // TODO: check Age here
                String ageEntry = String.valueOf(age.getText());
                Pattern resultAge = Pattern.compile("[0-9]{1,3}");
                Matcher testAge = resultAge.matcher(ageEntry);

                if (testAge.matches() == true) {
                    isAgeOk = true;
                    Toast.makeText(MainActivity.this, R.string.OKage, Toast.LENGTH_SHORT).show();
                }

                if (!isAgeOk) {
                    age.setError(getResources().getString(R.string.error_age));
                }

                boolean isAddressOk = false;
                // TODO: check Address here
                String addressEntry = String.valueOf(address.getText());
                Pattern resultAddress = Pattern.compile("[0-9]{1,3}(?:(?:[,. ]){1}[-a-zA-Zàâäéèêëïîôöùûüç]+)+[, ]+[0-9]{5} [a-zA-Z]{1,}");
                Matcher testAddress = resultAddress.matcher(addressEntry);

                if (testAddress.matches() == true) {
                    isAddressOk = true;
                    Toast.makeText(MainActivity.this, R.string.OKaddress, Toast.LENGTH_SHORT).show();
                }

                if (!isAddressOk) {
                    address.setError(getResources().getString(R.string.error_address));
                }

                boolean isEmailOk = false;
                // TODO: check Email here
                String emailEntry = String.valueOf(email.getText());
                Pattern resultEmail = Pattern.compile("^[\\w.-]+@[\\w.-]{2,}\\.[a-z]{2,5}$");
                Matcher testEmail = resultEmail.matcher(emailEntry);

                if (testEmail.matches() == true) {
                    isEmailOk = true;
                    Toast.makeText(MainActivity.this, R.string.OKemail, Toast.LENGTH_SHORT).show();
                }

                if (!isEmailOk) {
                    email.setError(getResources().getString(R.string.error_email));
                }

                if (isNameOk && isAgeOk && isAddressOk && isEmailOk) {
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.success), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
