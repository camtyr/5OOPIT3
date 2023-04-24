#Bước setup
git remote -v (Để kt xem đã link đến github nào chưa)
git init
git remote add origin https://github.com/camtyr/5OOPIT3.git
git add .
git commit -m "update"
git branch -M main
git push -u origin main
#Bước đưa code lên mỗi khi cần
git add .
git commit -m "update"
git push -u origin main