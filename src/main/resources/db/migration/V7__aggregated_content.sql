CREATE VIEW aggregated_content AS select l.id as id, l.date_added as date_added, 'link' as content_type from link l
union ALL
select p.id as id, p.date_added as date_added, 'podcast' as content_type from podcast p
order by date_added desc;


