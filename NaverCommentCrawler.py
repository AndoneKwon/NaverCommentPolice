from bs4 import BeautifulSoup
import requests
import re
import datetime
import pandas
from pandas import DataFrame

def flatten(l):
  flat_list = []

  for elem in l:
    if type(elem) == list:
      for e in elem:
        flat_list.append(e)
    else:
      flat_list.append(elem)

  return flat_list

base_url = "https://news.naver.com"
cur_date = datetime.date.today()

base_loc = "C:/Users/temp/Desktop/comm_list"

while True:
  str_date = str(cur_date).replace("-", "")

  if str_date == "20200331":
    break
  
  loc = base_loc + "/" + str_date + ".csv"

  url = "https://news.naver.com/main/ranking/popularMemo.nhn?rankingType=popular_memo&sectionId=100&date=" + str_date

  header = {
      "User-agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36",
      "referer": url
  }

  r =  requests.get(url, headers=header).text
  r = BeautifulSoup(r,"html.parser")

  headline_div = r.findAll('div', {'class' : 'ranking_headline'})

  comm_list = []

  for index, headline in enumerate(headline_div):
    print(str_date + " 날짜의 " + str(index + 1) + "번째 뉴스 기사 댓글 읽어오는 중...")
    url = base_url + headline.find('a')['href']
    
    oid = url.split("oid=")[1].split("&")[0]
    aid = url.split("aid=")[1]
    page = 1

    while True :
      c_url = "https://apis.naver.com/commentBox/cbox/web_neo_list_jsonp.json?ticket=news&templateId=default_society&pool=cbox5&_callback=jQuery1707138182064460843_1523512042464&lang=ko&country=&objectId=news"+oid+"%2C"+aid+"&categoryId=&pageSize=20&indexSize=10&groupId=&listType=OBJECT&pageType=more&page="+str(page)+"&refresh=false&sort=FAVORITE" 
      
      r =  requests.get(c_url, headers=header)
      cont = BeautifulSoup(r.content,"html.parser")    
      total_comm = str(cont).split('comment":')[1].split(",")[0]
      
      match = re.findall('"contents":([^\*]*),"userIdNo"', str(cont))

      for i in range(len(match)):
          match[i] = match[i].replace("\\n", "")
    
      comm_list.append(match)
      
      if int(total_comm) <= ((page) * 20):
        break
      else:
        page += 1

    comm_list = flatten(comm_list)
    print("총 댓글 수 : " + str(len(comm_list)))

  cur_date = datetime.datetime.strptime(str_date, "%Y%m%d").date()
  cur_date = cur_date - datetime.timedelta(1)

  comm_list = DataFrame(comm_list)
  comm_list.to_csv(loc, encoding="utf-8-sig", header=False, index=False)
