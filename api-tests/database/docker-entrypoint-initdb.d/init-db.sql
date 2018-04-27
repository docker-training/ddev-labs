-- create table for images

CREATE TABLE images
(
  imageid serial UNIQUE PRIMARY KEY,
  description character varying(10485760) NOT NULL,
  url character varying(255) NOT NULL
);

ALTER TABLE images
  OWNER TO gordonuser;
ALTER ROLE gordonuser CONNECTION LIMIT -1;

-- add image data
INSERT INTO images (description, url) VALUES('cat image', 'https://raw.githubusercontent.com/docker-training/catpics/master/16461916800_e138484673_z.jpg');
INSERT INTO images (description, url) VALUES('cat image', 'https://raw.githubusercontent.com/docker-training/catpics/master/18223540618_f9aab7c279_z.jpg');
INSERT INTO images (description, url) VALUES('cat image', 'https://raw.githubusercontent.com/docker-training/catpics/master/23215477792_8c3f868e42_z.jpg');
INSERT INTO images (description, url) VALUES('cat image', 'https://raw.githubusercontent.com/docker-training/catpics/master/26876813358_ee8b3fdc24_z.jpg');
INSERT INTO images (description, url) VALUES('cat image', 'https://raw.githubusercontent.com/docker-training/catpics/master/30296286162_fe3e4f9a01_z.jpg');
INSERT INTO images (description, url) VALUES('cat image', 'https://raw.githubusercontent.com/docker-training/catpics/master/37510597924_df820e0861_z.jpg');
INSERT INTO images (description, url) VALUES('cat image', 'https://raw.githubusercontent.com/docker-training/catpics/master/38664606845_697ef09086_z.jpg');
INSERT INTO images (description, url) VALUES('cat image', 'https://raw.githubusercontent.com/docker-training/catpics/master/39837778302_bc27f50808_z.jpg');
INSERT INTO images (description, url) VALUES('cat image', 'https://raw.githubusercontent.com/docker-training/catpics/master/53610823_93e96536c2_o.png');
INSERT INTO images (description, url) VALUES('cat image', 'https://raw.githubusercontent.com/docker-training/catpics/master/7956481290_ba196c0f39_z.jpg');
INSERT INTO images (description, url) VALUES('cat image', 'https://raw.githubusercontent.com/docker-training/catpics/master/8613868269_c9d8137a3c_z.jpg');
INSERT INTO images (description, url) VALUES('cat image', 'https://raw.githubusercontent.com/docker-training/catpics/master/9065891300_eb2d90fe7e_z.jpg');
INSERT INTO images (description, url) VALUES('cat image', 'http://placekitten.com/g/400/400');
