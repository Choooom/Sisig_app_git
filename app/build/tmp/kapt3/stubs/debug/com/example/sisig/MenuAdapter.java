package com.example.sisig;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/sisig/MenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/sisig/MenuAdapter$MenuViewHolder;", "menuItems", "", "Lcom/example/sisig/MenuItem;", "onAddClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "getItems", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MenuViewHolder", "app_debug"})
public final class MenuAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.sisig.MenuAdapter.MenuViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.sisig.MenuItem> menuItems = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.example.sisig.MenuItem, kotlin.Unit> onAddClick = null;
    
    public MenuAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.example.sisig.MenuItem> menuItems, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.sisig.MenuItem, kotlin.Unit> onAddClick) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.sisig.MenuAdapter.MenuViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.sisig.MenuAdapter.MenuViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.sisig.MenuItem> getItems() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/example/sisig/MenuAdapter$MenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "addButton", "Landroid/widget/Button;", "getAddButton", "()Landroid/widget/Button;", "description", "Landroid/widget/TextView;", "getDescription", "()Landroid/widget/TextView;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "name", "getName", "price", "getPrice", "serving", "getServing", "app_debug"})
    public static final class MenuViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView name = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView serving = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView description = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView price = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView imageView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.Button addButton = null;
        
        public MenuViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getServing() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getDescription() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getPrice() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImageView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.Button getAddButton() {
            return null;
        }
    }
}