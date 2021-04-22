<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        table {
            width: 50%;
            font-size: .938em;
            border-collapse: collapse; /*边框合并*/
        }

        th {
            text-align: left;
            padding: .5em .5em;
            font-weight: bold;
            background: #66677c;
            color: #fff;
        }

        td {
            padding: .5em .5em;
            border-bottom: solid 1px #ccc;
        }

        table, table tr th, table tr td {
            border: 1px solid #0094ff;
        }

        /*设置边框*/
    </style>
</head>
<body>
<h1>取值(${name!'暂无'}表示name值为''时默认值为暂无)</h1>
${name!'暂无'}
<h1>非空判断</h1>
<#if name?exists>
存在的
</#if>
<h1>条件表达式</h1>
<#if sex='女士'>
女士
<#elseif sex='男士'>
男士
<#else>
保密
</#if>
<h1>局部变量</h1>
<#assign ctx>
${springMacroRequestContext.contextPath}
</#assign>
${ctx}
<h1>#include</h1>
<#include 'foot.ftl'>
<h1>表格</h1>
<table>
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
    </tr>

<#list users as user>
    <tr>
        <td>${user.name}</td>
        <td>${user.sex}</td>
        <td>${user.age}</td>
    </tr>
</#list>

</table>

</body>
</html>