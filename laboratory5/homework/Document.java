package org.example;

import java.io.Serializable;
import java.util.*;

public class Document implements Serializable {
    private String id;
    private String title;
    private String location; //file name or Web page
    private Map<String, String> tags;
    public Document() {
        tags = new HashMap<>();
    }
    public Document(String id, String title) {
        this.id = id;
        this.title = title;
        tags = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String,String> getTags() {
        return tags;
    }
    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void addTag(String key, String value) {

        tags.put(key, value);
    }
    public String getTag(String key)
    {
        return tags.get(key);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Document{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append(", tags=").append(tags);
        sb.append('}');
        return sb.toString();
    }
}
