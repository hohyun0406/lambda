--SoccerTest.sql
--1- 전체 축구팀 목록을 팀이름 오름차순으로 출력하시오
--2- 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 빈공간으로 두시오
--3- 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오
--4- 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다.
--5- 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다.

--001. 전체 축구팀 목록을 팀이름 오름차순을 출력하시오
SELECT team_name
FROM team
ORDER BY team_name ASC;
--002. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 빈공간으로 두시오.
SELECT DISTINCT POSITION
FROM player;
--3- 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오
SELECT COALESCE(POSITION, '신입') AS 포지션
FROM player
GROUP BY POSITION;
--4- 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다.
SELECT player_name
FROM player
WHERE team_id = 'K02' AND POSITION = 'GK';
--5- 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다.
SELECT *
FROM player
WHERE team_id = 'K02' AND
      SUBSTRING(player_name, 1, 1) = '고' AND
      CAST(height AS SIGNED) >= 170;

-- 문제 6
-- 다음 조건을 만족하는 선수명단을 출력하시오
-- 소속팀이 삼성블루윙즈이거나
-- 드래곤즈에 소속된 선수들이어야 하고,
-- 포지션이 미드필더(MF:Midfielder)이어야 한다.
-- 키는 170 센티미터 이상이고 180 이하여야 한다.
SELECT *
FROM player
WHERE (team_id = 'K04' OR team_id = 'K06') -- 삼성블루윙즈 또는 드래곤즈
      AND POSITION = 'MF' -- 미드필더
      AND CAST(height AS SIGNED) >= 170 AND CAST(height AS SIGNED) <= 180; -- 키가 170 이상 180 이하

-- 문제 7-- 수원을 연고지로 하는 골키퍼는 누구인가?
SELECT player_name
FROM player
WHERE team_id = 'K02' AND POSITION = 'GK';

-- 문제 8-- 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오-- 키와 몸무게가 없으면 "0" 으로 표시하시오-- 키와 몸무게는 내림차순으로 정렬하시오
SELECT player_name,
       COALESCE(height, '0') AS height,
       COALESCE(weight, '0') AS weight
FROM player
WHERE team_id = 'K09'
ORDER BY
    CASE
        WHEN height IS NOT NULL THEN CAST(height AS SIGNED)
        ELSE 9999
    END DESC,
    CASE
        WHEN weight IS NOT NULL THEN CAST(weight AS SIGNED)
        ELSE 9999
    END DESC;

-- 문제 9-- 서울팀 선수들 이름과 포지션과
-- 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오
-- 단, 키와 몸무게가 없으면 "0" 표시하시오
-- BMI는 "NONE" 으로 표시하시오(as bmi)
-- 최종 결과는 이름내림차순으로 정렬하시오
SELECT player_name,
       POSITION,
       COALESCE(height, '0') AS height,
       COALESCE(weight, '0') AS weight,
       CASE
           WHEN height IS NOT NULL AND weight IS NOT NULL THEN
               ROUND(weight / POWER(height / 100, 2), 2)
           ELSE 'NONE'
       END AS bmi
FROM player
WHERE team_id = 'K09'
ORDER BY player_name DESC;