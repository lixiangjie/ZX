db.TestCollection.find({by:'zj'}).pretty()
db.TestCollection.insert({title:'mongodb',by:'lxj',tags:['mysql','oracle','mongodb','aaa'],lol:'lxj'})

db.TestCollection.remove({'title':'MongoDB教程教程'},{justOne:true})
db.TestCollection.remove({})

db.TestCollection.count({by:'zj'}) //查看总的个数

db.TestCollection.update({'title':'MongoDB 教程'},{$set:{'title':'MongoDB教程教程'}},{multi:true})

db.TestCollection.save({"_id":ObjectId("589d346037d97912486831e6"),by:'zj',tags:['mysql','oracle','mongodb','aaa'],lol:'lxj'})

db.TestCollection.insert({title: 'PHP 教程', 
    description: 'PHP 是一种创建动态交互性站点的强有力的服务器端脚本语言。',
    by: '菜鸟教程',
    url: 'http://www.runoob.com',
    tags: ['php'],
    likes: 200})

db.TestCollection.insert({title: 'Java 教程', 
    description: 'Java 是由Sun Microsystems公司于1995年5月推出的高级程序设计语言。',
    by: '菜鸟教程',
    url: 'http://www.runoob.com',
    tags: ['java'],
    likes: 150})
    
db.TestCollection.insert({title: 'MongoDB 教程', 
    description: 'MongoDB 是一个 Nosql 数据库',
    by: '菜鸟教程',
    url: 'http://www.runoob.com',
    tags: ['mongodb'],
    likes: 100})

db.TestCollection.find()

db.TestCollection.find({"likes":{$lte:200}})
db.TestCollection.find({"likes":{$gt:100,$lt:200}})

db.TestCollection.find({"likes":{$type:1}})

db.TestCollection.find({}).limit(2)

db.TestCollection.find({}).sort({_id:-1})

db.TestCollection.aggregate([{$group:{"_id":"$by",num_tutorial:{$avg:"$likes"}}}])

db.TestCollection.aggregate(
    { $project : {
        title : 1 ,
        by : 1 
    }}
 );

db.TestCollection.aggregate(
    {$match:{title:"PHP 教程"}}
    // {$group:{_id:null,count:{$sum:1}}}
 );
 
db.TestCollection.aggregate([{$group:{"_id":"$by",num:{$sum:"$likes"}}}])
 
db.TestCollection.aggregate({$sort:{"likes":-1}})
 
db.oplog.rs.find().limit(1).toArray()

db.TestCollection.insert({
    "_id":ObjectId("52ffc33cd85242f436000001"),
   "contact": "987654321",
   "dob": "01-01-1991",
   "name": "Tom Benzamin",
   "address": [
      {
         "building": "22 A, Indiana Apt",
         "pincode": 123456,
         "city": "Los Angeles",
         "state": "California"
      },
      {
         "building": "170 A, Acropolis Apt",
         "pincode": 456789,
         "city": "Chicago",
         "state": "Illinois"
      }]
})

db.TestCollection.find();
db.TestCollection.findOne({"name":"Tom Benzamin"},{"address":1});

ObjectId("589d346037d97912486831e6").getTimestamp();

//---
db.TestCollection.insert({
   "post_text": "菜鸟教程，最全的技术文档。",
   "user_name": "mark",
   "status":"disabled"
})

db.TestCollection.mapReduce(
    function(){emit(this.by,1)},//通过user_name进行分组
    function(key,values){return Array.sum(values)},
        {
            query:{lol:"lxj"},//筛选条件
            out:"post_total"//存储结果collection的名字，临时集合
        }
    )

db.TestCollection.find({tags:{$regex:"mongodb"}})

db.TestCollection.files.find()

db.createCollection("cappedLogCollection",{capped:true,size:10000,max:1000})
db.cappedLogCollection.isCapped()