DECLARE
  -- ランダム文字列を生成するための変数を定義
  TYPE typeListInt IS TABLE OF VARCHAR2(5 CHAR) INDEX BY BINARY_INTEGER;
  DataList typeListInt;

  -- 一括更新用にROWTYPE型変数を定義
  TYPE  typeTbData IS TABLE OF SAMPLE_TABLE%ROWTYPE INDEX BY BINARY_INTEGER;
  tbDataList typeTbData;
  
  -- 連番設定用
  wkID NUMBER(9);

BEGIN

  ----------------------------------------------
  -- 100万レコードのデータを作成
  ----------------------------------------------
  wkID := 0;
  FOR i IN 1..10 LOOP

    FOR j IN 1..100000 LOOP

      ----------------------------------------------
      -- 1からの連番を生成
      ----------------------------------------------
      wkID := wkID + 1;
      tbDataList(j).PRIMARY_KEY := wkID;

      ----------------------------------------------
      -- ランダムな文字列を生成
      ----------------------------------------------
      tbDataList(j).ITEM001 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM002 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM003 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM004 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM005 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM006 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM007 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM008 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM009 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM010 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM011 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM012 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM013 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM014 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM015 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM016 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM017 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM018 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM019 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM020 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM021 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM022 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM023 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM024 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM025 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM026 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM027 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM028 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM029 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM030 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM031 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM032 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM033 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM034 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM035 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM036 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM037 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM038 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM039 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM040 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM041 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM042 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM043 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM044 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM045 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM046 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM047 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM048 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM049 := DBMS_RANDOM.String('x',10);
      tbDataList(j).ITEM050 := DBMS_RANDOM.String('x',10);

    END LOOP;
    
    ----------------------------------------------
    -- 10万件分のデータをINSERT
    ----------------------------------------------
    FORALL j in 1..tbDataList.COUNT
      INSERT INTO SAMPLE_TABLE values tbDataList(j);
    COMMIT;

  END LOOP;

END;
/