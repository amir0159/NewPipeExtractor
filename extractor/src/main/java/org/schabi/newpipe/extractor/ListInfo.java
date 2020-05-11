package org.schabi.newpipe.extractor;

import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler;

import java.util.List;

import static org.schabi.newpipe.extractor.utils.Utils.isNullOrEmpty;

public abstract class ListInfo<T extends InfoItem> extends Info {
    private List<T> relatedItems;
    private String nextPageUrl = null;
    private final List<String> contentFilters;
    private final String sortFilter;

    public ListInfo(int serviceId,
                    String id,
                    String url,
                    String originalUrl,
                    String name,
                    List<String> contentFilter,
                    String sortFilter) {
        super(serviceId, id, url, originalUrl, name);
        this.contentFilters = contentFilter;
        this.sortFilter = sortFilter;
    }

    public ListInfo(int serviceId, ListLinkHandler listUrlIdHandler, String name) {
        super(serviceId, listUrlIdHandler, name);
        this.contentFilters = listUrlIdHandler.getContentFilters();
        this.sortFilter = listUrlIdHandler.getSortFilter();
    }

    public List<T> getRelatedItems() {
        return relatedItems;
    }

    public void setRelatedItems(List<T> relatedItems) {
        this.relatedItems = relatedItems;
    }

    public boolean hasNextPage() {
        return !isNullOrEmpty(nextPageUrl);
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String pageUrl) {
        this.nextPageUrl = pageUrl;
    }

    public List<String> getContentFilters() {
        return contentFilters;
    }

    public String getSortFilter() {
        return sortFilter;
    }
}