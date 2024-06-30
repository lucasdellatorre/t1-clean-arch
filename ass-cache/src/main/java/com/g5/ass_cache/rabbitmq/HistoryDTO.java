package com.g5.ass_cache.rabbitmq;

public class HistoryDTO { 
    private int assinaturaId;
    
    public HistoryDTO(int assinaturaId) { 
        this.assinaturaId = assinaturaId;
    } 
    
    public HistoryDTO() { 
    } 
    
    public int getAssinaturaId() { 
        return assinaturaId; 
    } 
    
    public void setAssinaturaId(int assinaturaId) { 
        this.assinaturaId = assinaturaId; 
    } 
    
    @Override 
    public String toString() { 
        return "HistoryDTO [assinaturaId=" + assinaturaId + "]"; 
    } 
}
