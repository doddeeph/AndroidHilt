package com.dph.android.hilt.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dph.android.hilt.data.Log
import com.dph.android.hilt.databinding.LogsRowItemBinding
import com.dph.android.hilt.util.DateFormatter

class LogsViewAdapter(
    private val logs: List<Log>,
    private val dateFormatter: DateFormatter
) : RecyclerView.Adapter<LogsViewAdapter.ViewHolder>() {

    private lateinit var binding: LogsRowItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = LogsRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(logs[position])
    }

    override fun getItemCount(): Int = logs.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(log: Log) {
            itemView.apply {
                binding.tvLog.text = "${log.msg}\n\t${dateFormatter.formatDate(log.timestamp)}"
            }
        }
    }
}