package com.dorakucommitters.assign.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Field Table
 * 過去の担当業務や保有資格の技術分野識別情報用テーブル
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "field")
public class Field
{
    @Id
    @GeneratedValue
    @Column(name = "field_id")
    private Integer fieldId;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @OneToMany(targetEntity = Qualification.class, mappedBy = "fieldId", fetch = FetchType.EAGER)
    private List<Qualification> qualifications;


    public Integer getFieldId()
    {
        return this.fieldId;
    }

    public String getFieldName()
    {
        return this.fieldName;
    }


    public void setFieldId(Integer fieldId)
    {
        this.fieldId = fieldId;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }


    /**
     * 当該専門分野に設定された資格オブジェクト
     *
     * @return List<Qualification>
     */
    public List<Qualification> getQualifications()
    {
        return this.qualifications;
    }


    /**
     * 当該オブジェクトが保持する情報をテキスト形式に変換する。
     * 主にデバッグ処理で使用する。
     *
     * @param  void
     * @return String  当該オブジェクトの情報
     */
    @Override
    public String toString()
    {
        return "id:" + this.fieldId
                + "name:" + this.fieldName;
    }
}
