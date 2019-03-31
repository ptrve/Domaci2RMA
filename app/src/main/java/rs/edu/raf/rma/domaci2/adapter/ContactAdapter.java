package rs.edu.raf.rma.domaci2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import rs.edu.raf.rma.domaci2.R;
import rs.edu.raf.rma.domaci2.model.Contact;
import rs.edu.raf.rma.domaci2.util.ContactDiffCallback;

public class ContactAdapter extends RecyclerView.Adapter<ContactHolder> {

    private List<Contact> mDataSet;

    public ContactAdapter() {
        mDataSet = new ArrayList<>();
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        Contact contact = mDataSet.get(position);
        Picasso.get().load(contact.getmImageUrl()).into(holder.hImage);
        holder.hIme.setText(contact.getName());
        holder.hPrezime.setText(contact.getmLastName());
        holder.hBroj.setText(contact.getmNumber());
        holder.hEmail.setText(contact.getmEmail());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void setData(List<Contact> contacts) {
        ContactDiffCallback callback = new ContactDiffCallback(mDataSet, contacts);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);
        mDataSet.clear();
        mDataSet.addAll(contacts);
        result.dispatchUpdatesTo(this);
    }
}
