/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pocketorigin.graphics;

import java.awt.Image;
import java.util.ArrayList;
/**
 * Copyright © 2022. All rights reserved.
 * @author Everything Huang
 */
public class Animation {
    
    private ArrayList frames;
    private int nowFrameIndex;
    private long animTime;
    private long totalDuration;
    
    public Animation(){
        this(new ArrayList(), 0);
    }
    
    private Animation(ArrayList frame, long totalDuration){
        this.frames = frames;
        this.totalDuration = totalDuration;
        start();
    }
    
    public Object clone(){
        return new Animation(frames, totalDuration);
    }
    
    public synchronized void addFrame(Image image, long duration){
        totalDuration += duration;
        frames.add(new AnimFrame(image, totalDuration));
    }
    
    public synchronized void start(){
        animTime = 0;
        nowFrameIndex = 0;
    }
    
    public synchronized void update(long elapsedTime){
        if(frames.size() > 1) {
            animTime += elapsedTime;
            if(animTime >= totalDuration){
                animTime = animTime%totalDuration;
                nowFrameIndex = 0;
            }
            while (animTime > getFrame(nowFrameIndex).endTime){
                nowFrameIndex++;
            }
        }
    }
    
    public synchronized Image getImage(){
        if (frames.size() == 0){
            return null;
        } else {
            return getFrame(nowFrameIndex).image;
        }
    }
    
    private AnimFrame getFrame(int i){
        return (AnimFrame)frames.get(i);
    }
    
    private class AnimFrame{
        Image image;
        long endTime;
        
        public AnimFrame(Image image, long endTime){
            this.image = image;
            this.endTime = endTime;
        }
    }
}

