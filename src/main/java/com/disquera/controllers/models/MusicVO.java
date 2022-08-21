package com.disquera.controllers.models;

public class MusicVO {
    String id, name, recordDate, recordingTime, idAlbum, status;

    public MusicVO(String id, String name, String recordDate, String recordingTime, String idAlbum, String status) {
        this.id = id;
        this.name = name;
        this.recordDate = recordDate;
        this.recordingTime = recordingTime;
        this.idAlbum = idAlbum;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecordingTime() {
        return recordingTime;
    }

    public void setRecordingTime(String recordingTime) {
        this.recordingTime = recordingTime;
    }

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
