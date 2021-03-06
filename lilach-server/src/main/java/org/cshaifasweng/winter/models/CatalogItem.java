package org.cshaifasweng.winter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.WhitespaceTokenizerFactory;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilterFactory;
import org.apache.lucene.analysis.ngram.EdgeNGramFilterFactory;
import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Indexed
@Entity
@JsonTypeName("catalog_item")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@AnalyzerDefs({
        @AnalyzerDef(name = "ngram",
                tokenizer = @TokenizerDef(factory = WhitespaceTokenizerFactory.class),
                filters = {
                        @TokenFilterDef(factory = ASCIIFoldingFilterFactory.class),
                        @TokenFilterDef(factory = LowerCaseFilterFactory.class),
                        @TokenFilterDef(factory = EdgeNGramFilterFactory.class,
                                params = {
                                        @Parameter(name = "minGramSize", value = "1"),
                                        @Parameter(name = "maxGramSize", value = "4")})
                }
        ),
        @AnalyzerDef(name = "ngram_query",
                tokenizer = @TokenizerDef(factory = WhitespaceTokenizerFactory.class),
                filters = {
                        @TokenFilterDef(factory = ASCIIFoldingFilterFactory.class),
                        @TokenFilterDef(factory = LowerCaseFilterFactory.class)
                }
        )
})
public class CatalogItem extends Item {

    public CatalogItem() {
        super();
    }

    @Field
    private String description;

    private String picture;

    private long availableCount = 0;

    private long itemsSold = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Store store;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CustomItem> customItems;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean canBeAssembled;

    private double discountAmount;

    private double discountPercent;

    @Field(index = Index.YES, analyze = Analyze.YES, store = org.hibernate.search.annotations.Store.NO)
    @Analyzer(definition = "ngram")
    private CatalogItemType itemType;

    public CatalogItem(double price, String description,
                       String picture, long availableCount, Store store, boolean canBeAssembled,
                       CatalogItemType itemType) {
        this.price = price;
        this.description = description;
        this.picture = picture;
        this.availableCount = availableCount;
        this.store = store;
        this.customItems = new ArrayList<>();
        this.canBeAssembled = canBeAssembled;
        this.discountAmount = 0.0;
        this.discountPercent = 0.0;
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(long availableCount) {
        this.availableCount = availableCount;
    }

    public long getItemsSold() {
        return itemsSold;
    }

    public void setItemsSold(long itemsSold) {
        this.itemsSold = itemsSold;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<CustomItem> getCustomItems() {
        return customItems;
    }

    public void setCustomItems(List<CustomItem> customItems) {
        this.customItems = customItems;
    }

    public boolean isCanBeAssembled() {
        return canBeAssembled;
    }

    public void setCanBeAssembled(boolean canBeAssembled) {
        this.canBeAssembled = canBeAssembled;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public CatalogItemType getItemType() {
        return itemType;
    }

    public void setItemType(CatalogItemType itemType) {
        this.itemType = itemType;
    }
}
