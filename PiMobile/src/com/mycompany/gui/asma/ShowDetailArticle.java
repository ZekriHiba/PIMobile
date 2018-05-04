/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.asma;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.MediaPlayer;
import static com.codename1.ui.CN.isSimulator;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.asma.Article;
import com.codename1.components.MultiButton;
import com.codename1.components.ToastBar;
import com.codename1.io.Log;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import static com.codename1.ui.CN.CENTER;
import static com.codename1.ui.CN.callSerially;
import static com.codename1.ui.CN.scheduleBackgroundTask;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;

/**
 *
 * @author User
 */
public class ShowDetailArticle {
    
    
    private Form f;
    private Label titre;
    private ImageViewer imageviewer;
    private ImageViewer img;
    private EncodedImage encodedImage;
    private Image urlImage;
        private MediaPlayer mp;

    
    public ShowDetailArticle(Resources theme, Article a) {
             MultiButton helloOnline = new MultiButton("Hello (Online)");

        f=new Form("Detail Article",BoxLayout.y());
        Container ctn = new Container(BoxLayout.x());
         titre= new Label(a.getTitle_Article());
        Container ctn1= new Container(BoxLayout.x());
          encodedImage=EncodedImage.createFromImage(theme.getImage("round.png"), false);
          
          urlImage = URLImage.createToStorage(encodedImage,"tt"+String.valueOf(a.getAricle_ID()),"http://localhost"+a.getImg(),URLImage.RESIZE_SCALE_TO_FILL);
          img =new ImageViewer(urlImage); 
               
          if(isSimulator()) {
            helloOnline.addActionListener(e -> playVideo(f, "http://localhost"+a.getVideo()));
        } else {
            helloOnline.addActionListener(e -> playVideo(f, "http://localhost"+a.getVideo()));
        }
          ctn.add(helloOnline);
          ctn.add(titre);
          ctn1.add(img);
          f.add(ctn);
          f.add(ctn1);
          
          f.getToolbar().addCommandToLeftBar("", theme.getImage("back-command.png"), (e)->{
  
          ShowListArticle sla = new ShowListArticle(theme);
          sla.getF().show();
          });

    }
    
    private void playVideo(Form parent, String videoUrl) {
        Form player = new Form(new BorderLayout());
        player.getToolbar().setBackCommand("", e -> {
            if (mp != null) {
                mp.getMedia().cleanup();
            }
            parent.showBack();
        });
        player.add(CENTER, new InfiniteProgress());
        scheduleBackgroundTask(() -> {
            try {
                Media video = MediaManager.createMedia(videoUrl, true, () -> parent.showBack());
                video.prepare();
                callSerially(() -> {
                    if (mp != null){
                        mp.getMedia().cleanup();
                    }
                    mp = new MediaPlayer(video);
                    mp.setAutoplay(true);
                    video.setNativePlayerMode(true);
                    player.removeAll();
                    player.add(CENTER, mp);
                    player.revalidate();
                });
            } catch(IOException err) {
                Log.e(err);
                ToastBar.showErrorMessage("Error loading video: " + err);
            }
        });
        player.show();
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
