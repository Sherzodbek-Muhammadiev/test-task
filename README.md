# test-task
Task Description
GENERAL
On the first launch app must create two tables in sqlite database, one for Users one for Items and
populate both tables with 100 entities. 
User attributes: User name, creation date, Id (username can be "User"+ID e.g. "User 1")
Item attributes: Item name, Id (E.g. "Item 1")

PAGE 1
This page should contain Users, first load 10 users with descending order and on scrolling down load more users untill the end (Pagination). Plus button available on this page and on click it must add new data on top of the table and scroll to first item.

PAGE 2
This page should contain Objects returned from api.
API returns  
In case api server does not respond or internet is not available proper message ("Server is not responding, please check internet connection...") must be shown with reload button.  API returns array of objects with fields like "name" and "image". It used for advertising of our apps. You need to show only name and image inside list. All items can be populated at once into the view. Plus button must be hidden on this page.

API Request:
GET https://adsrv.sab-lab.com/api/show/app/60?uuid=fghy123sdasdasdasdasafgdfgdfa&secret=bqgqkbxgOaU3pPEt
{"zone": [
    {
      "name": "Islom fullscreen",
      "type": "image",
      "url": "https://adsrv.sab-lab.com/api/link/96/41/50/309122",
      "priority": 0,
      "files": [
        {
          "url": "https://adsrv.sab-lab.com/file/115",
          "type": "vertical"
        }
      ]
    },
...
}
]}
Fields:
name – name of the app (you must show it)
type, url, priority – ignore this fields
in “files” section: url – download link of the image to show
PAGE 3
This page should contain Items, first load 10 items with descending order and on scrolling down load more users untill the end (Pagination). Plus button available on this page and on click it must add new data on top of the table and scroll to first item.


