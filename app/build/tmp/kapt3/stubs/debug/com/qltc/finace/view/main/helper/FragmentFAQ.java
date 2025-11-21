package com.qltc.finace.view.main.helper;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseFragment;
import com.qltc.finace.data.entity.FAQItem;
import com.qltc.finace.databinding.FragmentFaqBinding;
import com.qltc.finace.view.adapter.FAQAdapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u001a\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001e"}, d2 = {"Lcom/qltc/finace/view/main/helper/FragmentFAQ;", "Lcom/qltc/finace/base/BaseFragment;", "Lcom/qltc/finace/databinding/FragmentFaqBinding;", "Lcom/qltc/finace/view/main/helper/FAQViewModel;", "Lcom/qltc/finace/view/main/helper/FAQListener;", "()V", "faqAdapter", "Lcom/qltc/finace/view/adapter/FAQAdapter;", "layoutID", "", "getLayoutID", "()I", "viewModel", "getViewModel", "()Lcom/qltc/finace/view/main/helper/FAQViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getFAQData", "", "Lcom/qltc/finace/data/entity/FAQItem;", "loadFAQData", "", "onBackClick", "onOpenNotebookLMClick", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupRecyclerView", "app_debug"})
public final class FragmentFAQ extends com.qltc.finace.base.BaseFragment<com.qltc.finace.databinding.FragmentFaqBinding, com.qltc.finace.view.main.helper.FAQViewModel> implements com.qltc.finace.view.main.helper.FAQListener {
    private final int layoutID = com.qltc.finace.R.layout.fragment_faq;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.qltc.finace.view.adapter.FAQAdapter faqAdapter;
    
    public FragmentFAQ() {
        super();
    }
    
    @java.lang.Override()
    protected int getLayoutID() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.qltc.finace.view.main.helper.FAQViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void loadFAQData() {
    }
    
    private final java.util.List<com.qltc.finace.data.entity.FAQItem> getFAQData() {
        return null;
    }
    
    @java.lang.Override()
    public void onOpenNotebookLMClick() {
    }
    
    @java.lang.Override()
    public void onBackClick() {
    }
}