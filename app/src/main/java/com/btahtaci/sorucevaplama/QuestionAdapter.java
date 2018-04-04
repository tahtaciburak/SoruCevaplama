package com.btahtaci.sorucevaplama;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by buraktahtaci on 4.04.2018.
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>{
    private Context mCtx;
    List<Question> questionsList;
    CustomItemClickListener listener;

    public QuestionAdapter(Context mCtx,List<Question> questionsList,CustomItemClickListener listener){
        this.mCtx = mCtx;
        this.questionsList = questionsList;
        this.listener = listener;
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_question_list, null);
        final QuestionViewHolder qvh = new QuestionViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v,qvh.getPosition());
            }
        });
        return qvh;
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        //getting the product of the specified position
        Question question = questionsList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(question.getQuestionText());
        holder.textViewShortDesc.setText(question.getCategory());
    }


    @Override
    public int getItemCount() {
        return questionsList.size();
    }


    class QuestionViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;

        public QuestionViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            //textViewRating = itemView.findViewById(R.id.textViewRating);
        }
    }
}
