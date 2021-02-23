package com.guideelectric.daterangepicker.widget.listener;


import com.guideelectric.daterangepicker.widget.DateScrollerDialog;

/**
 * 日期设置的监听器
 *
 * @author C.L. Wang
 */
public interface OnDateSetListener {
    void onDateSet(DateScrollerDialog timePickerView, long milliseconds, long milliFinishSeconds);
}
