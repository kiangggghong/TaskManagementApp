package com.example.perfectplanner;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTaskActivity extends ActionBar{

    private DatabaseReference mDatabase;

    private EditText mTitle;
    private EditText mDueDate;
    private EditText mDueTime;
    private EditText mDescription;
    private EditText mTagFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_add_task, null, false);
        drawer.addView(contentView, 0);

        initialiseFirebaseDatabase();
        initialiseUI();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new TaskCalendarDialog();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TaskTimerDialog();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void initialiseUI() {
        mTitle = (EditText) findViewById(R.id.sTaskTitle);
        mDueTime = (EditText) findViewById(R.id.sTaskDueTime);
        mDueDate = (EditText) findViewById(R.id.sTaskDueDate);
        mDescription = (EditText) findViewById(R.id.sDescription);
        mTagFriend = (EditText) findViewById(R.id.sTagFriend);

    }

    public void initialiseFirebaseDatabase() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void onConfirmedPressed(View v) {
        writeToDatabase();
    }

    private void writeToDatabase() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            final String uID = user.getUid();
            String id = mDatabase.child("Tasks").child(uID).push().getKey();

            mDatabase.child("Tasks").child(uID).child(id).setValue("InProgress");

            mDatabase.child("TasksDetails").child(id).child("Title").setValue(mTitle.getText().toString());
            mDatabase.child("TasksDetails").child(id).child("Due Time").setValue(mDueTime.getText().toString());
            mDatabase.child("TasksDetails").child(id).child("Due Date").setValue(mDueDate.getText().toString());
            mDatabase.child("TasksDetails").child(id).child("Description").setValue(mDescription.getText().toString());
            mDatabase.child("TasksDetails").child(id).child("TagFriend").setValue(mTagFriend.getText().toString());
        }
    }
}
