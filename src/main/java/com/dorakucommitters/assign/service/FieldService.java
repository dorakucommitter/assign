package com.dorakucommitters.assign.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dorakucommitters.assign.domain.Field;
import com.dorakucommitters.assign.repository.FieldRepository;

@Service
@Transactional
public class FieldService
{
    @Autowired
    FieldRepository fieldRepository;

    /**
     * Fieldテーブルエントリ全取得処理
     *
     * @Param  void
     * @return List<Field>
     */
    public List<Field> findAll()
    {
        return this.fieldRepository.findAll();
    }

    /**
     * Fieldテーブルエントリ主キー指定取得処理
     *
     * @param Integer id  Primary Key of the Field Table
     * @return
     */
    public Field findOne(Integer id)
    {
        return this.fieldRepository.findOne(id);
    }

    /**
     * Fieldテーブルエントリ作成処理
     * TODO: 主キー指定するとエラーになるかも(未確認)。
     *
     * @param field  Object of the Field Table Entry
     * @return
     */
    public Field create(Field field)
    {
        return this.fieldRepository.save(field);
    }

    /**
     * Fieldテーブルエントリ更新処理
     * fieldオブジェクトの主キーが一致するテーブルエントリの情報を更新する。
     * TODO: 主キー不一致の場合エラーになるかも(未確認)。
     *
     * @param field  Object of the Field Table Entry
     * @return
     */
    public Field update(Field field)
    {
        return this.fieldRepository.save(field);
    }

    /**
     * Fieldテーブルエントリ主キー指定削除処理
     *
     * @param  Integer id  Primary Key of the Field Table
     * @return void
     */
    public void delete(Integer id)
    {
        this.fieldRepository.delete(id);
    }
}
