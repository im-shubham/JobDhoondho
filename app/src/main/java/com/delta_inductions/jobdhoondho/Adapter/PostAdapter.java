package com.delta_inductions.jobdhoondho.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.delta_inductions.jobdhoondho.Model.Post;
import com.delta_inductions.jobdhoondho.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class PostAdapter extends FirestoreRecyclerAdapter<Post, PostAdapter.PostHolder> {
    public PostAdapter(@NonNull FirestoreRecyclerOptions<Post> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PostHolder holder, int position, @NonNull Post model) {
        holder.posttext.setText("Position :"+model.getPosition()+"\n\n"+"Salary :"+model.getSalary()+"\n\n"+"Job Location :"+model.getLocation()+"\n\n"+"Job duration :"+model.getWork_period()+"\n\n"+"Job description :"+ model.getDescription());
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_cardview,parent,false);
        return (new PostHolder(V));
    }

    public class PostHolder extends RecyclerView.ViewHolder{
        private TextView posttext;
        public PostHolder(@NonNull View itemView) {
            super(itemView);
            posttext = itemView.findViewById(R.id.postjobdetails);
        }
    }
}
