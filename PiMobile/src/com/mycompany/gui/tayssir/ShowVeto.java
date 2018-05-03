package com.mycompany.gui.tayssir;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;


public class ShowVeto extends Form  {
    public ShowVeto(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Label gui_doudou = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_dousou = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("ShowVeto");
        setName("ShowVeto");
        addComponent(gui_doudou);
        addComponent(gui_dousou);
        gui_doudou.setPreferredSizeStr("8.201058mm inherit");
        gui_doudou.setText("Veto");
        gui_doudou.setUIID("ll1");
                gui_doudou.setInlineStylesTheme(resourceObjectInstance);
        gui_doudou.setName("doudou");
        ((com.codename1.ui.layouts.LayeredLayout)gui_doudou.getParent().getLayout()).setInsets(gui_doudou, "36.843487% auto auto 42.877094%").setReferenceComponents(gui_doudou, "-1 -1 -1 -1").setReferencePositions(gui_doudou, "0.0 0.0 0.0 0.0");
        gui_dousou.setText("dsfsdf");
                gui_dousou.setInlineStylesTheme(resourceObjectInstance);
        gui_dousou.setName("dousou");
        ((com.codename1.ui.layouts.LayeredLayout)gui_dousou.getParent().getLayout()).setInsets(gui_dousou, "auto 32.681564% 30.691057% auto").setReferenceComponents(gui_dousou, "-1 -1 -1 -1").setReferencePositions(gui_dousou, "0.0 0.0 0.0 0.0");
    }// </editor-fold>
//-- DON'T EDIT ABOVE THIS LINE!!!
}
