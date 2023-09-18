package com.example.firebase;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import android.view.View;
public class RecycleAdapter extends RecyclerView.Adapter< RecycleAdapter.Myviewholder> {
    Context context;
    int flag=0;
    questionModel getinfo;
    SelectItem item;
    ArrayList<questionModel> questionlist;


    public RecycleAdapter(Context context, ArrayList<questionModel> questionlist) {
        this.context = context;
        this.questionlist = questionlist;
    }

    @NonNull
    @Override
    public RecycleAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemlist,parent,false);
        return new Myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.Myviewholder holder,
                                 @SuppressLint("RecyclerView") int position) {
        getinfo=questionlist.get(position);
        holder.question.setText(questionlist.get(position).getQuestion());
        holder.option1.setText(questionlist.get(position).getOption1());
        holder.option2.setText(questionlist.get(position).getOption2());
        holder.option3.setText(questionlist.get(position).getOption3());
        holder.option4.setText(questionlist.get(position).getOption4());
        holder.answer.setVisibility(View.GONE);
        holder.llanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0){
                    holder.answer.setText(questionlist.get(position).getAnswer());
                    holder.answer.setVisibility(View.VISIBLE);
                    flag=1;
                } else if (flag==1) {
                    holder.answer.setText(null);
                    holder.answer.setVisibility(View.GONE);
                    flag=0;
                }

            }
        });

        holder.option1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Log.d("Tushar", String.valueOf(questionlist.get(position).getOption1()));
                Log.d("Tushar", String.valueOf(questionlist.get(position).getAnswer()));

                String a = String.valueOf(questionlist.get(position).getOption1());
                String b = String.valueOf(questionlist.get(position).getAnswer());
                if(a.equals(b)){
                    Toast.makeText(context, "correct", Toast.LENGTH_SHORT).show();
                    holder.option1.setBackgroundColor(ContextCompat.getColor(context, R.color.correct));
                    holder.option2.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option4.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option3.setBackgroundColor(ContextCompat.getColor(context, R.color.white));

                }
                else {
//                    Toast.makeText(context, "wrong", Toast.LENGTH_SHORT).show();
                    holder.option1.setBackgroundColor(ContextCompat.getColor(context, R.color.wrong));
                    holder.option2.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option3.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option4.setBackgroundColor(ContextCompat.getColor(context, R.color.white));

                }

            }
        });

        holder.option2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Log.d("Tushar", String.valueOf(questionlist.get(position).getOption2()));
                Log.d("Tushar", String.valueOf(questionlist.get(position).getAnswer()));

                String a = String.valueOf(questionlist.get(position).getOption2());
                String b = String.valueOf(questionlist.get(position).getAnswer());
                if(a.equals(b)){
                    Toast.makeText(context, "correct", Toast.LENGTH_SHORT).show();
                    holder.option2.setBackgroundColor(ContextCompat.getColor(context, R.color.correct));
                    holder.option3.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option4.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option1.setBackgroundColor(ContextCompat.getColor(context, R.color.white));

                }
                else {
//                    Toast.makeText(context, "wrong", Toast.LENGTH_SHORT).show();
                    holder.option1.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option2.setBackgroundColor(ContextCompat.getColor(context, R.color.wrong));
                    holder.option3.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option4.setBackgroundColor(ContextCompat.getColor(context, R.color.white));


                }
            }
        });
        holder.option3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Log.d("Tushar", String.valueOf(questionlist.get(position).getOption3()));
                Log.d("Tushar", String.valueOf(questionlist.get(position).getAnswer()));

                String a = String.valueOf(questionlist.get(position).getOption3());
                String b = String.valueOf(questionlist.get(position).getAnswer());
                if(a.equals(b)){
//                    Toast.makeText(context, "correct", Toast.LENGTH_SHORT).show();
                    holder.option3.setBackgroundColor(ContextCompat.getColor(context, R.color.correct));
                    holder.option2.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option4.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option1.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                }
                else {
//                    Toast.makeText(context, "wrong", Toast.LENGTH_SHORT).show();
                    holder.option1.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option2.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option3.setBackgroundColor(ContextCompat.getColor(context, R.color.wrong));
                    holder.option4.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                }
            }
        });
        holder.option4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Log.d("Tushar", String.valueOf(questionlist.get(position).getOption4()));
                Log.d("Tushar", String.valueOf(questionlist.get(position).getAnswer()));

                String a = String.valueOf(questionlist.get(position).getOption4());
                String b = String.valueOf(questionlist.get(position).getAnswer());
                if(a.equals(b)){
                    Toast.makeText(context, "correct", Toast.LENGTH_SHORT).show();
                    holder.option4.setBackgroundColor(ContextCompat.getColor(context, R.color.correct));
                    holder.option2.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option3.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option1.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                }
                else {
//                    Toast.makeText(context, "wrong", Toast.LENGTH_SHORT).show();
                    holder.option1.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option2.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option3.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    holder.option4.setBackgroundColor(ContextCompat.getColor(context, R.color.wrong));

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return questionlist.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        TextView question,option1,option2,option3,option4,answer;
        LinearLayout llanswer;
        CardView c1,c2,c4,c3;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.question);
            option1 = itemView.findViewById(R.id.option1);
            option2 = itemView.findViewById(R.id.option2);
            option3 = itemView.findViewById(R.id.option3);
            option4 = itemView.findViewById(R.id.option4);
            answer = itemView.findViewById(R.id.answer);
            llanswer = itemView.findViewById(R.id.answerll);
            c1 = itemView.findViewById(R.id.optionA);
            c2 = itemView.findViewById(R.id.optionB);
            c3 = itemView.findViewById(R.id.optionC);
            c4 = itemView.findViewById(R.id.optionD);

        }
    }
}
